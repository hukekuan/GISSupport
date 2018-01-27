package com.gis3c.ol.service.impl;

import com.gis3c.ol.dao.SourceDao;
import com.gis3c.ol.entity.Source;
import com.gis3c.ol.entity.source.TileArcGISRest;
import com.gis3c.ol.entity.source.TileSuperMapRest;
import com.gis3c.ol.entity.source.Vector;
import com.gis3c.ol.entity.source.Wmts;
import com.gis3c.ol.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hukekuan on 2017/12/15.
 */
@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceDao sourceDao;

    @Override
    public TileArcGISRest findTileArcGISRestById(String sourceId) {
        return sourceDao.findTileArcGISRestById(sourceId);
    }

    @Override
    public TileArcGISRest findTileArcGISRestByName(String sourceName) {
        return sourceDao.findTileArcGISRestByName(sourceName);
    }

    @Override
    public Integer insertTileArcGISRest(TileArcGISRest tileArcGISRest) {
        return sourceDao.insertTileArcGISRest(tileArcGISRest);
    }

    @Override
    public TileSuperMapRest findTileTileSuperMapRestById(String sourceId) {
        return sourceDao.findTileTileSuperMapRestById(sourceId);
    }

    @Override
    public TileSuperMapRest findTileTileSuperMapRestByName(String sourceName) {
        return sourceDao.findTileTileSuperMapRestByName(sourceName);
    }

    @Override
    public Integer insertTileSuperMapRest(TileSuperMapRest tileSuperMapRest) {
        return sourceDao.insertTileSuperMapRest(tileSuperMapRest);
    }

    @Override
    public Vector findVectorById(String sourceId) {
        return sourceDao.findVectorById(sourceId);
    }

    @Override
    public Vector findVectorByName(String sourceName) {
        return sourceDao.findVectorByName(sourceName);
    }

    @Override
    public Integer insertVector(Vector vector) {
        return sourceDao.insertVector(vector);
    }

    @Override
    public Wmts findWmtsById(String sourceId) {
        return sourceDao.findWmtsById(sourceId);
    }

    @Override
    public Wmts findWmtsByName(String sourceName) {
        return sourceDao.findWmtsByName(sourceName);
    }

    @Override
    public Integer insertWmts(Wmts wmts) {
        return sourceDao.insertWmts(wmts);
    }

    @Override
    public List<Source> findAllSources() {
        return sourceDao.findAllSources();
    }

    @Override
    public void insertSource(Source source) {
        sourceDao.insertSource(source);
    }
}
