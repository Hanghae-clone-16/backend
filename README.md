# Clone coding - velog.io

항해99 [chapter 4]에서 진행한

Spring boot와 React 를 이용한 ([velog](https://velog.io)) 클론코딩 프로젝트입니다.



## 팀원 역할

### Frontend

* 이정주(github.com/JeongJoo-Lee)
  * 1
* 길근용(github.com/TESZhao123)
  * 1

### Backend

* 강이현(github.com/kellykang-tech)
  * CRUD 기능 구현 / cors 설정 / 
* 홍종완(gitHub.com/jongwanhong)
  * 환경설정 / 데이터 크롤링 / 

## API 설계

| 기능             | Method | URL                     | 반환                    |
| ---------------- | ------ | ----------------------- | ----------------------- |
| 전체 게시글 조회 | GET    | /api/boards             | List<Board>             |
| 특정 게시글 조회 | GET    | /api/detail/{id}        | Board                   |
| 게시글 작성      | POST   | /api/boards             | Board                   |
| 게시글 수정      | PUT    | /api/boards/{id}        | id                      |
| 게시글 삭제      | DELETE | /api/boards/{id}        | id                      |
| 로그인           | POST   | /users/login            | Username,password,token |
| 회원가입         | POST   | /users/signup           | Username,password       |
| 댓글 조회        | GET    | /api/comments/{post_id} | List<Comment>           |
| 댓글 작성        | POST   | /api/comments           | Comment                 |
| 댓글 수정        | PUT    | /api/comments/{id}      | id                      |
| 댓글 삭제        | DELETE | /api/comments/{id}      | id                      |

 

## 3계층 설계

1. Controller

- BoardController : 게시글 관련 컨트롤러

- HomeController : 페이지 간 이동 컨트롤러

- UserController : 인증 및 인가처리 컨트롤러

- CommentController : 댓글 관련 컨트롤러

  

2. Service

- BoardService : 게시글 처리

- UserService : 인증 및 인가처리

- CommentService : 댓글 처리

  

3. Domain

   3.1. Model

   * Board : 게시글 테이블 - 제목, 작성자명, 작성 날짜

   * User : 유저 테이블 - 아이디, 패스워드, 이메일, 역할, 카카오아이디

   * Comment : 댓글 테이블 - 작성자명, 작성날짜, 내용

     

   3.2 Repository

   * BoardRepository : 게시글 DB 접근

   * UserRepository : 회원정보 DB 접근

   * CommentRepository : 댓글 DB 접근

     

   3.3 Dto

   * BoardRequestDto : 게시글 수정 / 등록
   * SignupRequestDto : 회원가입
   * CommentReqeustDto : 댓글 수정 / 등록

## 구조 - Backend
![image](https://user-images.githubusercontent.com/53491653/113465588-184ed680-9470-11eb-9afd-96eb04152fdb.png)



