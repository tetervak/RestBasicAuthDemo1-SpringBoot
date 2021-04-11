package ca.tetervak.restbasicauthdemo1.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.web.AuthenticationEntryPoint

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authEntryPoint: AuthenticationEntryPoint
) : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(security: HttpSecurity) {
        security.csrf().disable().authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
            .authenticationEntryPoint(authEntryPoint)
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {

        auth
            .inMemoryAuthentication()
            .withUser("marge")
            .password(
                PasswordEncoderFactories.createDelegatingPasswordEncoder()
                    .encode("sesame")
            )
            .roles("USER")
    }
}
