package com.gis3c.ol.dao;

import com.gis3c.common.persistence.annotation.C3olDao;
import com.gis3c.ol.entity.Layer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by hukekuan on 2017/12/15.
 */
@C3olDao
public interface LayerDao {
    public List<Layer> findAllList();
    public List<Layer> findLayersByPage(
            @Param("pageSize") Integer pageSize,
            @Param("currentPage") Integer currentPage);

    public Layer findeLayerById(String layerId);
    public Layer findeLayerByName(String layerName);

    public Integer insertLayer(Layer layer);

    public Integer deleteLayersById(Set<String> layerIds);
}
