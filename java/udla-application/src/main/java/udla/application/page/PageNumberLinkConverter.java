package udla.application.page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import udla.common.data.common.AbstractConverter;
import udla.common.data.page.PageNumBasedPageLink;

@Component
public class PageNumberLinkConverter extends AbstractConverter<PageNumBasedPageLink, Pageable> {

  @Override
  public Pageable convertTo(PageNumBasedPageLink pageLink) {
    return PageRequest.of(pageLink.getPageNum(), pageLink.getPageSize());
  }

  @Override
  public PageNumBasedPageLink convertFrom(Pageable pageable) {
    return new PageNumBasedPageLink(pageable.getPageSize(), pageable.getPageNumber());
  }
}
