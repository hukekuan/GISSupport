package com.gis3c.spatial.common;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;
import org.geotools.geometry.jts.JTS;
import org.geotools.geometry.jts.JTSFactoryFinder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Geometry相关方法
 * Created by hukekuan on 2017/12/11.
 */
public class GeometryUtilities {
    private final static GeometryFactory geomFactory = JTSFactoryFinder.getGeometryFactory();
    private final static WKTReader reader = new WKTReader(geomFactory);
    private final static WKTWriter write = new WKTWriter();

    /**
     * 根据坐标信息生成Point
     * @param coordinate
     * @return
     */
    public static Point CreatePoint(Coordinate coordinate){
        return geomFactory.createPoint(coordinate);
    }

    /**
     * 根据经纬度生成Point
     * @param lon 经度
     * @param lat 维度
     * @return
     */
    public static Point CreatePoint(double lon, double lat){
        return geomFactory.createPoint(new Coordinate(lat, lon));
    }

    /**
     * wkt转geometry
     * @param wktStr
     * @return
     * @throws ParseException
     */
    public static Geometry Wkt2Geometry(String wktStr) throws ParseException {
        Geometry resultGeometry = null;
        if(wktStr == null || "".equals(wktStr)){
            return resultGeometry;
        }
        resultGeometry = reader.read(wktStr);

        return resultGeometry;
    }

    /**
     * geometry转wkt
     * @param geometry
     * @return
     */
    public static String Geometry2Wkt(Geometry geometry){
        String resultWkt=null;

        if(geometry == null){
            return resultWkt;
        }
        resultWkt = write.write(geometry);
        return resultWkt;
    }

    public static Point JSONObject2Point(JSONObject jsonObj){
        Point resultPoint = null;
        if(jsonObj != null){
            resultPoint = GeometryUtilities.CreatePoint(jsonObj.getDouble("x"),jsonObj.getDouble("y"));
        }
        return resultPoint;
    }

    public static LineString JSONObject2LineString(JSONArray jsonPaths){
        LineString resultLineString = null;
        JSONArray pointArray;
        JSONArray pointJSON;
        List<Coordinate> coordinateList;

        if(jsonPaths != null && jsonPaths.size() > 0){
            coordinateList = new ArrayList<>();
            pointArray = jsonPaths.getJSONArray(0);
            for(Object pointObj : pointArray){
                pointJSON = (JSONArray) pointObj;
                coordinateList.add(new Coordinate(pointJSON.getDouble(0),pointJSON.getDouble(1)));
            }
            if(coordinateList.size() > 0){
                resultLineString = geomFactory.createLineString((Coordinate[]) coordinateList.toArray(new Coordinate[0]));
            }
        }

        return resultLineString;
    }

    public static Polygon JSONObject2Polygon(JSONArray jsonRings){
        Polygon resultPolygon = null;
        JSONArray pointArray;
        JSONArray pointJSON;
        List<Coordinate> coordinateList;
        LinearRing linearRing = null;
        List<LinearRing> holeRings;

        if(jsonRings != null && jsonRings.size() > 0){
            if(jsonRings.size() == 1){
                pointArray = (JSONArray) jsonRings.get(0);
                coordinateList = new ArrayList<>();
                for(Object pointObj : pointArray){
                    pointJSON = (JSONArray) pointObj;
                    coordinateList.add(new Coordinate(pointJSON.getDouble(0),pointJSON.getDouble(1)));
                }
                resultPolygon = geomFactory.createPolygon((Coordinate[]) coordinateList.toArray(new Coordinate[0]));

            }else if(jsonRings.size() > 1){
                holeRings = new ArrayList<>();
                for(Object ring : jsonRings){
                    pointArray = (JSONArray) ring;
                    coordinateList = new ArrayList<>();
                    for(Object pointObj : pointArray){
                        pointJSON = (JSONArray) pointObj;
                        coordinateList.add(new Coordinate(pointJSON.getDouble(0),pointJSON.getDouble(1)));
                    }

                    if(linearRing == null){
                        linearRing = geomFactory.createLinearRing((Coordinate[]) coordinateList.toArray(new Coordinate[0]));
                    }else{
                        holeRings.add(geomFactory.createLinearRing((Coordinate[]) coordinateList.toArray(new Coordinate[0])));
                    }
                }
                resultPolygon = geomFactory.createPolygon(linearRing,(LinearRing[])holeRings.toArray(new LinearRing[0]));
            }
        }
        return resultPolygon;
    }

    public static ReferencedEnvelope Geometry2Envelope(Geometry geometry){
        ReferencedEnvelope resultEnvelope = null;
        if(geometry != null && (geometry instanceof Polygon || geometry instanceof MultiPolygon)){
            Coordinate[] coordinates = geometry.getEnvelope().getCoordinates();
            double xmin = 180,xmax = 0,ymin = 90,ymax=0;
            if(coordinates != null && coordinates.length == 5){
                for(Coordinate coordinate : coordinates){
                    if(xmin > coordinate.x){
                        xmin = coordinate.x;
                    }
                    if(xmax < coordinate.x){
                        xmax = coordinate.x;
                    }
                    if(ymin > coordinate.y){
                        ymin = coordinate.y;
                    }
                    if(ymax < coordinate.y){
                        ymax = coordinate.y;
                    }
                }
                resultEnvelope = new ReferencedEnvelope(xmin, xmax, ymin, ymax, DefaultGeographicCRS.WGS84);
            }
        }
        return resultEnvelope;
    }

    public static Polygon Line2Polygon(LineString lineString,ReferencedEnvelope referencedEnvelope,Polygon envelopePolygon)
            throws IllegalArgumentException{
        if(lineString == null || referencedEnvelope == null || envelopePolygon == null){
            throw new IllegalArgumentException("Line2Polygon方法参数输入有误");
        }

        Polygon polygonFromLine = null;
        LineString intersectLine = null;
        Geometry intersectGeo = null;

        Coordinate[] lineCoordinate;
        List<Coordinate> coordinateList;

        if(lineString.isClosed()){
            polygonFromLine = geomFactory.createPolygon(geomFactory.createLinearRing(lineString.getCoordinates()),null);
            if(!envelopePolygon.contains(polygonFromLine)){
                intersectGeo = polygonFromLine.intersection(envelopePolygon);
                if(intersectGeo instanceof Polygon){
                    polygonFromLine = (Polygon) intersectGeo;
                }
            }
        }else if(!lineString.isEmpty()){
            lineCoordinate = lineString.getCoordinates();
            double minX = referencedEnvelope.getMinX(),
                    maxX = referencedEnvelope.getMaxX(),
                    minY = referencedEnvelope.getMinY(),
                    maxY = referencedEnvelope.getMaxY();
            Point centerPoint;
            coordinateList = new ArrayList(Arrays.asList(lineCoordinate));

            if(Math.abs(lineCoordinate[0].x - minX) < 0.00001 && Math.abs(lineCoordinate[lineCoordinate.length - 1].x - maxX) < 0.00001){
                centerPoint = lineString.getCentroid();
                if(centerPoint.getY() <= (minY + maxY)/2){
                    coordinateList.add(new Coordinate(maxX,minY));
                    coordinateList.add(new Coordinate(minX,minY));
                }else{
                    coordinateList.add(new Coordinate(maxX,maxY));
                    coordinateList.add(new Coordinate(minX,maxY));
                }
                coordinateList.add(lineCoordinate[0]);

                lineCoordinate = coordinateList.toArray(new Coordinate[0]);
                polygonFromLine = geomFactory.createPolygon(geomFactory.createLinearRing(lineCoordinate),null);
            }else if(Math.abs(lineCoordinate[0].x - maxX) < 0.00001 && Math.abs(lineCoordinate[lineCoordinate.length - 1].x-minX) < 0.00001) {
                centerPoint = lineString.getCentroid();
                if(centerPoint.getY() <= (minY + maxY)/2){
                    coordinateList.add(new Coordinate(minX,minY));
                    coordinateList.add(new Coordinate(maxX,minY));
                }else{
                    coordinateList.add(new Coordinate(minX,maxY));
                    coordinateList.add(new Coordinate(maxX,maxY));
                }
                coordinateList.add(lineCoordinate[0]);

                lineCoordinate = coordinateList.toArray(new Coordinate[0]);
                polygonFromLine = geomFactory.createPolygon(geomFactory.createLinearRing(lineCoordinate),null);
            }else if(Math.abs(lineCoordinate[0].y - minY) < 0.00001 && Math.abs(lineCoordinate[lineCoordinate.length - 1].y - maxY) < 0.00001){
                centerPoint = lineString.getCentroid();
                if(centerPoint.getX() <= (minX + maxX)/2){
                    coordinateList.add(new Coordinate(minX,maxY));
                    coordinateList.add(new Coordinate(minX,minY));
                }else{
                    coordinateList.add(new Coordinate(maxX,maxY));
                    coordinateList.add(new Coordinate(maxX,minY));
                }
                coordinateList.add(lineCoordinate[0]);

                lineCoordinate = coordinateList.toArray(new Coordinate[0]);
                polygonFromLine = geomFactory.createPolygon(geomFactory.createLinearRing(lineCoordinate),null);
            }else if(Math.abs(lineCoordinate[0].y-maxY) < 0.00001 && Math.abs(lineCoordinate[lineCoordinate.length - 1].y - minY) < 0.00001){
                centerPoint = lineString.getCentroid();
                if(centerPoint.getX() <= (minX + maxX)/2){
                    coordinateList.add(new Coordinate(minX,minY));
                    coordinateList.add(new Coordinate(minX,maxY));
                }else{
                    coordinateList.add(new Coordinate(maxX,minY));
                    coordinateList.add(new Coordinate(maxX,maxY));
                }
                coordinateList.add(lineCoordinate[0]);

                lineCoordinate = coordinateList.toArray(new Coordinate[0]);
                polygonFromLine = geomFactory.createPolygon(geomFactory.createLinearRing(lineCoordinate),null);
            }else if(lineCoordinate[0].x == lineCoordinate[lineCoordinate.length - 1].x
                    || lineCoordinate[0].y == lineCoordinate[lineCoordinate.length - 1].y){
                coordinateList.add(lineCoordinate[0]);

                lineCoordinate = coordinateList.toArray(new Coordinate[0]);
                polygonFromLine = geomFactory.createPolygon(geomFactory.createLinearRing(lineCoordinate),null);
            }else{
                Coordinate startCoordinate = lineCoordinate[0];
                Coordinate endCoordinate = lineCoordinate[lineCoordinate.length - 1];
                double x = 0,y = 0;

                if(startCoordinate.x == minX || startCoordinate.x == maxX){
                    x = startCoordinate.x;
                }
                if(startCoordinate.y == minY || startCoordinate.y == maxY){
                    y = startCoordinate.y;
                }

                if(endCoordinate.x == minX || endCoordinate.x == maxX){
                    x = endCoordinate.x;
                }
                if(endCoordinate.y == minY || endCoordinate.y == maxY){
                    y = endCoordinate.y;
                }
                if(x != 0 && y != 0){
                    coordinateList.add(new Coordinate(x,y));
                }
                coordinateList.add(lineCoordinate[0]);
                lineCoordinate = (Coordinate[]) coordinateList.toArray(new Coordinate[0]);
                if(lineCoordinate.length >= 4){
                    polygonFromLine = geomFactory.createPolygon(geomFactory.createLinearRing(lineCoordinate),null);
                }

            }
        }

        return polygonFromLine;
    }

    public static MultiPolygon Geometry2MuitlPolygon(Geometry geometry){
        MultiPolygon resultPolygon = null;
        if(geometry != null){
            if(geometry instanceof Polygon){
                Polygon[] polygons = new Polygon[]{(Polygon)geometry};
                resultPolygon = geomFactory.createMultiPolygon(polygons);
            }else if(geometry instanceof MultiPolygon){
                resultPolygon = (MultiPolygon) geometry;
            }
        }
        return resultPolygon;
    }

    public static GeometryCollection GeometryCollection(List<Geometry> geometryList){
        GeometryCollection gc
                = geomFactory.createGeometryCollection((Geometry[]) geometryList.toArray(new Geometry[0]));
        return gc;
    }

    public static Geometry GetBoundaryFromGeometries(List<Geometry> geometryList){
        GeometryCollection gc = GeometryCollection(geometryList);
        return gc.getEnvelope();
    }

    /**
     * 生成Buffer
     * @param geometry
     * @param distance
     * @return
     */
    public Polygon CreateBuffer(Geometry geometry,Double distance){
        Polygon bufferResult = null;
        if(geometry == null || distance == null){
            throw new IllegalArgumentException("参数输入有误");
        }
        bufferResult = (Polygon) geometry.buffer(distance, 100);

        return bufferResult;
    }

    public Polygon CreateBufferByPoint(Double lon,Double lat,Double distance){
        Point point = CreatePoint(lon,lat);
        return CreateBuffer(point,distance);
    }

    /**
     * 计算两个点之间的距离
     * @param startPoint
     * @param endPoint
     * @return
     * @throws FactoryException
     * @throws IOException
     */
    public static Double PointDistance(Point startPoint,Point endPoint)
            throws TransformException, FactoryException {
        int sridValue;
        if(startPoint == null || endPoint == null){
            throw new IllegalArgumentException("参数输入有误");
        }
        sridValue = startPoint.getSRID();
        if(sridValue != endPoint.getSRID()){
            throw new IllegalArgumentException("坐标系不一致");
        }
        if(sridValue == 0){
            sridValue = 4326;
        }

        return JTS.orthodromicDistance(
                startPoint.getCoordinate(),
                endPoint.getCoordinate(),
                CRSUtilities.GetCRSFromSRID(String.valueOf(sridValue))
        );
    }
}
