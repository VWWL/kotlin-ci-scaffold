package com.qomolangma.iam.gateways

import com.qomolangma.frameworks.security.core.ContextProvider
import com.qomolangma.iam.domain.AccessTokenContextProvider
import com.qomolangma.iam.domain.AccessTokens
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class IamConfiguration {
    @Bean
    fun contextProvider(accessTokenRepository: AccessTokens): ContextProvider {
        return AccessTokenContextProvider(accessTokenRepository)
    }
}