//package net.ict.kiosk.config;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration    // 설정파일로 지정
//@RequiredArgsConstructor     //injection 하기위해
//@Log4j2
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//
//public class CustomSecurityConfig {
//
//        @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//            log.info("------------configure-------------------");
//
//            //커스텀 로그인 페이지
//            http.formLogin();
//            //CSRF 토큰 비활성화
//            http.csrf().disable();
//
//            return null;    // 사용자에게 http 경로 오픈 - 로그레벨 조절하여(httpsecurity 이용하여) 자원 요청가능
//        }

 //   }