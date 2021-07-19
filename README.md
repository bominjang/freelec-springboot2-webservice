# freelec-springboot2-webservice

## 이곳에는 공부하면서 새로 알게된 것들을 기록합니다 :)

### Spring 웹 계층

- Web Layer
```
    컨트롤러와 JSP/Freemarker 등의 뷰 템플릿 영역
    필터, 인터셉트, 컨트롤러 어드바이스 등 외부 유ㅛ청과 응답에 대한 전반적인 영역
```

- Service Layer
```
    @Service에 사용되는 서비스 영역
    일반적으로 Controllerdhk Dao의 중간 영역에서 사용됨.
    @Transactional이 사용되어야하는 영역 
```

- Repository Layer
```
    DB에 접근하는 영역
    Dao(Data Access Object) 영역
```

- Dtos
```
    Dto(Data Transfer Object)는 계층 간에 데이터 교환을 위한 객체를 이야기 함. Dtos는 이들의 영역을 말함.
```

- Domain Model
```
    예를 들어 택시 앱에서는 배차, 탑승, 요금 등이 도메인이 됨.
    비즈니스 처리를 담당.
```

### 템플릿 엔진

템플릿 엔진이란?
```
    지정된 템플릿 양식과 데이터가 합쳐져 HTML문서를 출력하는 소프트웨어
```

- 서버 템플릿 엔진을 이용한 화면 생성 : 서버에서 Java 코드로 문자열을 만든 뒤 이 문자열을 HTML로 변환하여 브라우저로 전달.
- 클라이언트 템플릿 엔진을 이용한 화면 생성 : 브라우저에서 화면을 생성. 즉, 서버에서 이미 코드가 벗어난 경우.
