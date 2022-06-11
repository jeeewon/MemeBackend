# MemeBackend
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