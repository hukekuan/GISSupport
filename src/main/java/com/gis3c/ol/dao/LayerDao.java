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
    public List<Layer> findLayerList();
    public List<Layer> findLayersByPage(
            @Param("pageSize") Integer pageSize,
            @Param("currentPage") Integer currentPage);

    public Layer findeLayerById(String layerId);
    public Layer findeLayerByName(String layerName);
    public List<Layer> findLayerByIds(String[] layerIds);

    public Integer insertLayer(Layer layer);

    public Integer bindSource(
            @Param("layerId") String layerId,
            @Param("sourceId") String sourceId,
            @Param("options") java.util.Map<String,Object> options
    );
    public Integer deleteLayersById(Set<String> layerIds);
}
