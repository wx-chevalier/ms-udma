package udla.application.infra.area;

import org.springframework.stereotype.Component;
import udla.common.data.common.AbstractConverter;
import udla.common.data.shared.id.AreaId;
import udla.common.data.shared.id.BaseEntityId;
import udla.domain.infra.area.Area;
import udla.infra.tunnel.db.infra.area.AreaDO;

@Component
public class AreaConverter extends AbstractConverter<Area, AreaDO> {

  @Override
  public AreaDO convertTo(Area area) {
    return new AreaDO()
        .setId(convertNullable(area.getId(), BaseEntityId::getId))
        .setName(area.getName())
        .setAreaCode(area.getAreaCode())
        .setLevel(area.getLevel())
        .setMergerName(area.getMergerName())
        .setParentCode(area.getParentCode())
        .setShortName(area.getShortName())
        .setCityCode(area.getCityCode())
        .setLat(area.getLat())
        .setLng(area.getLng())
        .setZipCode(area.getZipCode());
  }

  @Override
  public Area convertFrom(AreaDO areaDO) {
    return new Area()
        .setId(convertNullable(areaDO.getId(), AreaId::new))
        .setName(areaDO.getName())
        .setAreaCode(areaDO.getAreaCode())
        .setLevel(areaDO.getLevel())
        .setMergerName(areaDO.getMergerName())
        .setParentCode(areaDO.getParentCode())
        .setShortName(areaDO.getShortName())
        .setCityCode(areaDO.getCityCode())
        .setLat(areaDO.getLat())
        .setLng(areaDO.getLng())
        .setZipCode(areaDO.getZipCode());
  }
}
