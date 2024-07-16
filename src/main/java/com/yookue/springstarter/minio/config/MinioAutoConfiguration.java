/*
 * Copyright (c) 2020 Yookue Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yookue.springstarter.minio.config;


import jakarta.annotation.Nonnull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.yookue.commonplexus.springcondition.annotation.ConditionalOnAllProperties;
import com.yookue.springstarter.minio.property.MinioProperties;
import com.yookue.springstarter.minio.util.MinioConfigurationUtils;
import io.minio.MinioClient;


/**
 * Configuration for {@link io.minio.MinioClient}
 *
 * @author David Hsing
 * @reference "https://min.io/"
 * @see io.minio.MinioClient
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnAllProperties(value = {
    @ConditionalOnProperty(prefix = MinioAutoConfiguration.PROPERTIES_PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true),
    @ConditionalOnProperty(prefix = MinioAutoConfiguration.PROPERTIES_PREFIX, name = "host")
})
@ConditionalOnClass(value = MinioClient.class)
@EnableConfigurationProperties(value = MinioProperties.class)
@SuppressWarnings({"JavadocDeclaration", "JavadocLinkAsPlainText"})
public class MinioAutoConfiguration {
    public static final String PROPERTIES_PREFIX = "spring.minio";    // $NON-NLS-1$
    public static final String MINIO_CLIENT = "minioClient";    // $NON-NLS-1$

    @Bean(name = MINIO_CLIENT)
    @ConditionalOnMissingBean(name = MINIO_CLIENT)
    public MinioClient minioClient(@Nonnull MinioProperties properties) throws Exception {
        return MinioConfigurationUtils.minioClient(properties);
    }
}
