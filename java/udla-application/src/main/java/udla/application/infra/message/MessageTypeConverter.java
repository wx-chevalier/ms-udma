package udla.application.infra.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import udla.common.data.common.AbstractConverter;
import udla.common.data.infra.message.MessageTemplate;
import udla.common.data.infra.message.MessageTemplateSerializer;
import udla.common.data.infra.notice.NoticeType;
import udla.common.data.shared.id.*;
import udla.common.data.shared.id.BaseEntityId;
import udla.common.data.shared.id.MessageTypeId;
import udla.domain.infra.message.MessageType;
import udla.infra.tunnel.db.infra.message.MessageTypeDO;

@Slf4j
@Component
public class MessageTypeConverter extends AbstractConverter<MessageType, MessageTypeDO> {

  @Override
  public MessageTypeDO convertTo(MessageType messageType) {

    MessageTemplateSerializer instance = MessageTemplateSerializer.instance();
    String template = convertNullable(messageType.getTemplate(), instance::toJson);

    return new MessageTypeDO()
        .setId(convertNullable(messageType.getId(), BaseEntityId::getId))
        .setKey(convertNullable(messageType.getKey(), NoticeType::name))
        .setName(messageType.getName())
        .setKind(messageType.getKind().name())
        .setTenantId(convertNullable(messageType.getTenantId(), BaseEntityId::getId))
        .setTemplate(template);
  }

  @Override
  public MessageType convertFrom(MessageTypeDO messageTypeDO) {

    // 构造模板
    MessageTemplate messageTemplate = new MessageTemplate();

    messageTemplate
        .setEmailTemplate(messageTypeDO.getEmailTemplate())
        .setSiteMessageTemplate(messageTypeDO.getSiteMessageTemplate())
        .setSmsTemplateId(messageTypeDO.getSmsTemplateCode())
        .setWechatTemplateId(messageTypeDO.getWechatTemplateCode());

    return new MessageType(
        convertNullable(messageTypeDO.getId(), MessageTypeId::new),
        convertNullable(messageTypeDO.getKey(), NoticeType::valueOf),
        convertNullable(messageTypeDO.getTenantId(), TenantId::new),
        null,
        messageTypeDO.getCreatedAt(),
        messageTypeDO.getUpdatedAt(),
        messageTypeDO.getName(),
        messageTypeDO.getKind(),
        messageTemplate);
  }
}
