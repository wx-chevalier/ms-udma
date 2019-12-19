package udla.domain.infra.filestore;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import udla.common.data.infra.filestore.PreSignedUrl;
import udla.common.data.shared.id.*;
import udla.common.data.shared.id.FileId;

public interface StoredFileCommandService {

  StoredFile saveToLocalStore(TenantId tenantId, String fileName, File file);

  StoredFile saveOssFile(TenantId tenantId, String fileName, String ossFileKey);

  PreSignedUrl getPreSignedUrl(TenantId tenantId, StoredFile storedFile);

  void removeByIds(TenantId tenantId, Collection<FileId> fileIds);

  StoredFile compressFiles(TenantId tenantId, String name, List<FileId> fileIds) throws IOException;
}
