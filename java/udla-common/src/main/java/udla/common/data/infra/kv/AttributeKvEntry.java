package udla.common.data.infra.kv;

public interface AttributeKvEntry<T> extends KvEntry<T> {
  Long getLastUpdateTs();
}
