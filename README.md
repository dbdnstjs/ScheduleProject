---

##📝 API 명세

###1. 사용자 인증 API
| HTTP Method | URL | 설명 |
| :--- | :--- | :--- |
| `POST` | `/signup` | **회원가입**: 새로운 사용자를 등록합니다. |
| `POST` | `/login` | **로그인**: 이메일과 비밀번호로 로그인하고 세션을 발급합니다. |
| `POST` | `/logout` | **로그아웃**: 현재 세션을 무효화합니다. |

###2. 일정 관리 API
| HTTP Method | URL | 설명 |
| :--- | :--- | :--- |
| `POST` | `/schedules` | **일정 생성**: 새 일정을 생성합니다. |
| `GET` | `/schedules` | **전체 일정 조회**: 모든 일정을 조회합니다. |
| `GET` | `/schedules/{scheduleId}` | **특정 일정 조회**: `scheduleId`에 해당하는 일정을 조회합니다. |
| `PUT` | `/schedules/{scheduleId}` | **일정 수정**: `scheduleId`에 해당하는 일정을 수정합니다. |
| `DELETE` | `/schedules/{scheduleId}` | **일정 삭제**: `scheduleId`에 해당하는 일정을 삭제합니다. |

###3. 사용자 정보 API
| HTTP Method | URL | 설명 |
| :--- | :--- | :--- |
| `GET` | `/users` | **전체 사용자 조회**: 모든 사용자를 조회합니다. |
| `GET` | `/users/{userId}` | **특정 사용자 조회**: `userId`에 해당하는 사용자를 조회합니다. |
| `PUT` | `/users/{userId}` | **사용자 수정**: `userId`에 해당하는 사용자 정보를 수정합니다. |
| `DELETE` | `/users/{userId}` | **사용자 삭제**: `userId`에 해당하는 사용자를 삭제합니다. |

---
