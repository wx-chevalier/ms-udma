package udla.infra.common.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import udla.common.data.code.ApiErrorCode;

/**
 * 业务异常基类.
 *
 * <p>应用状态主要区分几类状态：
 *
 * <ul>
 *   <li>正常，无异常
 *   <li>应用出错 {@link InternalServerException}
 *   <li>接口出错 {@link BadRequestException}
 *   <li>权限异常 {@link UnAuthorizedException} & {@link ForbiddenException}
 * </ul>
 */
public class BaseBizException extends RuntimeException {

  @Getter private HttpStatus status;

  @Getter @Setter private ApiErrorCode code;

  public BaseBizException(HttpStatus status) {
    this.status = status;
  }

  public BaseBizException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }

  public BaseBizException(String message, Throwable cause, HttpStatus status) {
    super(message, cause);
    this.status = status;
  }
}
