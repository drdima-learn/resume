package net.devstudy.resume.configuration;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(2)
public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        // Assigning default decorator if no path specific decorator found
        builder.addDecoratorPath("/*", "/WEB-INF/template/page-template.jsp")
                // Map decorators to specific path patterns.
                //.addDecoratorPath("/login", "/WEB-INF/sitemesh/simpleDecorator .jsp")
                // Exclude few paths from decoration.
                .addExcludedPath("/javadoc/*")
                .addExcludedPath("/brochures/*");
    }
}
