# MemeBackend
|팀원|역할|
|------|-------------------|
|이민재|DB설계,API설게,더미데이터 생성,</br>전반적인 환경설정 및 배포(AWS RDS-MYSQL연동,테이블 생성,이미지처리,AWS S3-EC2연동,배포 스크립트 작성,AWS EC2배포)|
|이지원|DB설계,API설계,더미데이터 생성,</br>전반적인 서버 프로그래밍(회원가입 및 로그인,게시글 등록,조회,좋아요,북마크,신고,댓글,마이페이지,비밀번호수정,회원탈퇴)|
````bash
└─src
    ├─main
    │  ├─generated
    │  ├─java
    │  │  └─org
    │  │      └─example
    │  │          └─demo
    │  │              ├─config
    │  │              ├─domain
    │  │              │  ├─bookmark : 북마크 entity
    │  │              │  ├─comment : 댓글 entity
    │  │              │  ├─forbidden : 금지단어 entity
    │  │              │  ├─user : 회원 entity
    │  │              │  └─posts : 게시글 entity
    │  │              ├─security
    │  │              ├─services
    │  │              │  ├─bookmark : 북마크 service (북마크 추가,삭제,중복방지처리)
    │  │              │  ├─comment : 댓글 service (댓글 작성)
    │  │              │  ├─forbidden : 금지단어 service (금지단어 추가,금지단어 필터링,금지단어 게시글 삭제)
    │  │              │  ├─main : 메인페이지 service (랭킹)
    │  │              │  ├─user : 회원 service (회원가입,로그인,로그아웃,회원탈퇴,마이페이지)
    │  │              │  └─posts : 게시글 service (게시글 작성,타입/카테고리별 조회,키워드 검색,상세 페이지)
    │  │              └─web
    │  │                  └─controller : API  
    │  │                  └─dto
    │  │                      ├─bookmark : 북마크 DTO
    │  │                      ├─comment : 댓글 DTO
    │  │                      ├─forbidden : 금지단어 DTO
    │  │                      ├─member : 회원 DTO
    │  │                      └─posts : 게시글 DTO (request,response,list_response)
    │  └─resources : key
    └─test
        └─java
            └─org
                └─example
                    └─demo
                        └─web
                            └─dto
````
