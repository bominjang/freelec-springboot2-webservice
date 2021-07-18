# freelec-springboot2-webservice

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

