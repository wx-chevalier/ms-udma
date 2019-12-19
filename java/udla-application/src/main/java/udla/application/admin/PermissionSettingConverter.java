package udla.application.admin;

import org.springframework.stereotype.Component;
import udla.common.data.common.AbstractConverter;
import udla.common.data.shared.id.*;
import udla.common.data.shared.id.PermissionSettingId;
import udla.domain.admin.PermissionSetting;
import udla.infra.tunnel.db.admin.PermissionSettingDO;

@Component
public class PermissionSettingConverter
    extends AbstractConverter<PermissionSetting, PermissionSettingDO> {

  @Override
  public PermissionSettingDO convertTo(PermissionSetting permissionSetting) {
    return new PermissionSettingDO()
        .setId(permissionSetting.getId().getId())
        .setTenantId(permissionSetting.getTenantId().getId())
        .setApplicationId(permissionSetting.getApplicationId().getId())
        .setDirectory(permissionSetting.getDirectory());
  }

  @Override
  public PermissionSetting convertFrom(PermissionSettingDO permissionSettingDO) {
    return new PermissionSetting(
        new PermissionSettingId(permissionSettingDO.getId()),
        new TenantId(permissionSettingDO.getTenantId()),
        permissionSettingDO.getCreatedAt(),
        permissionSettingDO.getUpdatedAt(),
        permissionSettingDO.getPermissionName(),
        new ApplicationId(permissionSettingDO.getApplicationId()),
        permissionSettingDO.getDirectory());
  }
}
