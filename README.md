# MemeBackend
````bash
C:.
├─.gradle
│  ├─4.10.2
│  │  ├─fileChanges
│  │  ├─fileContent
│  │  ├─fileHashes
│  │  ├─javaCompile
│  │  ├─taskHistory
│  │  └─vcsMetadata-1
│  ├─buildOutputCleanup
│  └─vcs-1
├─.idea
│  └─shelf
│      ├─Uncommitted_changes_before_Update_at_2022-06-09_오후_3_29_[Changes]
│      └─Uncommitted_changes_before_Update_at_2022-06-09_오후_5_04_[Changes]
├─build
│  ├─classes
│  │  └─java
│  │      ├─main
│  │      │  └─org
│  │      │      └─example
│  │      │          └─demo
│  │      │              ├─config
│  │      │              ├─domain
│  │      │              │  └─posts
│  │      │              ├─services
│  │      │              │  └─posts
│  │      │              └─web
│  │      │                  └─dto
│  │      │                      ├─member
│  │      │                      └─posts
│  │      └─test
│  │          └─org
│  │              └─example
│  │                  └─demo
│  │                      └─web
│  │                          └─dto
│  ├─reports
│  │  └─tests
│  │      └─test
│  │          ├─classes
│  │          ├─css
│  │          ├─js
│  │          └─packages
│  ├─resources
│  │  └─main
│  ├─test-results
│  │  └─test
│  │      └─binary
│  └─tmp
│      ├─compileJava
│      └─compileTestJava
├─gradle
│  └─wrapper
├─out
│  └─production
│      ├─classes
│      │  └─org
│      │      └─example
│      │          └─demo
│      │              ├─config
│      │              ├─domain
│      │              │  ├─bookmark
│      │              │  ├─comment
│      │              │  ├─forbidden
│      │              │  ├─member
│      │              │  └─posts
│      │              ├─security
│      │              ├─services
│      │              │  ├─bookmark
│      │              │  ├─comment
│      │              │  ├─forbidden
│      │              │  ├─main
│      │              │  ├─member
│      │              │  └─posts
│      │              └─web
│      │                  └─dto
│      │                      ├─comment
│      │                      ├─forbidden
│      │                      ├─member
│      │                      └─posts
│      └─resources
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
