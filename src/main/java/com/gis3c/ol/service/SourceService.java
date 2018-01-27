package com.gis3c.ol.service;

import com.gis3c.ol.entity.Source;
import com.gis3c.ol.entity.source.TileArcGISRest;
import com.gis3c.ol.entity.source.TileSuperMapRest;
import com.gis3c.ol.entity.source.Vector;
import com.gis3c.ol.entity.source.Wmts;

import java.util.List;

/**
 * Created by hukekuan on 2017/12/15.
 */
public interface SourceService {
    public TileArcGISRest findTileArcGISRestById(String sourceId);
    public TileArcGISRest findTileArcGISRestByName(String sourceName);

    public Integer insertTileArcGISRest(TileArcGISRest tileArcGISRest);



    public TileSuperMapRest findTileTileSuperMapRestById(String sourceId);
    public TileSuperMapRest findTileTileSuperMapRestByName(String sourceName);

    public Integer insertTileSuperMapRest(TileSuperMapRest tileSuperMapRest);



    public Vector findVectorById(String sourceId);
    public Vector findVectorByName(String sourceName);

    public Integer insertVector(Vector vector);



    public Wmts findWmtsById(String sourceId);
    public Wmts findWmtsByName(String sourceName);

    public Integer insertWmts(Wmts wmts);


    public List<Source> findAllSources();
    public void insertSource(Source source);
}
