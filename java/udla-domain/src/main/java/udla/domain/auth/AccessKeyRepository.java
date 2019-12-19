package udla.domain.auth;

import java.util.Optional;
import udla.common.data.shared.id.*;

public interface AccessKeyRepository {

  AccessKey save(AccessKey accessKey);

  boolean removeKey(AccessKey accessKey);

  Optional<AccessKey> findByKey(TenantId tenantId, String key);

  Optional<AccessKey> findByKey(String key);
}
