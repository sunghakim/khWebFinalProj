<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/info.css">
    <title>내정보</title>
</head>
<body  class="info">
    <div>
    <div class="infoHeader">
        <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
        <label><h1>내정보</h1></label>
    </div>
    <div class="form">
    <form id="update-Info">
        <table>
            <tr>
                <th>아이디</th>
                <td colspan="3">abcd1234</td>
            </tr>
            <tr>
                <th>닉네임</th>
                <td colspan="2">
                    <label id="nick">abcd</label>
                    <input id="nick-Input" type="text" value="" style="display: none;"/>
                </td>
                <td>
                    <button id="nick-Btn" type="button">변경하기</button>
                    <button class="back" type="button" style="display: none;">취소</button>
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td colspan="3">
                    <input id="txtPwd" type="text" value="1234" hidden/>
                    <button id="bootstrap-update-pwd" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">변경하기</button></td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td colspan="2">
                    <label id="phone">010-1234-5678</label>
                    <input id="phone-Input" type="text" value="" style="display: none;"/>
                </td>
                <td>
                    <button id="phone-Btn" type="button">수정하기</button>
                    <button class="back" type="button" style="display: none;">취소</button>
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td colspan="2">
                    <label id="email">1234@mail.com</label>
                    <input id="email-Input" type="text" value="" style="display: none;"/>
                </td>
                <td>
                    <button id="email-Btn" type="button">수정하기</button>
                    <button class="back" type="button" style="display: none;">취소</button>
                </td>
            </tr>
            <tr>
                <th rowspan="3">주소</th>
                <th>우편번호</th>
                <td>
                    <label id="postalCode">12345</label>
                    <input id="postalCode-Input" type="text" value="" style="display: none;"/>
                </td>
                <td>
                    <button id="postalCode-Btn" type="button">수정하기</button>
                    <button class="back" type="button" style="display: none;">취소</button>
                </td>
            </tr>
            <tr>
                <th>주소지</th>
                <td>
                    <label id="address1">경기도 어딘가 하나아파트</label>
                    <input id="address1-Input" type="text" value="" style="display: none;"/>
                </td>
                <td>
                    <button id="address1-Btn" type="button">수정하기</button>
                    <button class="back" type="button" style="display: none;">취소</button>
                </td>
            </tr>
            <tr>
                <th>상세주소</th>
                <td>
                    <label id="address2">둘 동 셋 호</label>
                    <input id="address2-Input" type="text" value="" style="display: none;"/>
                </td>
                <td>
                    <button id="address2-Btn" type="button">수정하기</button>
                    <button class="back" type="button" style="display: none;">취소</button>
                </td>
            </tr>
        </table>
    </form>
    </div>
    <hr>
    <div class="button">
        <a href="#">회원탈퇴</a>
        <div>
            <button id="cancel">취소</button>
            <button id="submit">수정완료</button>
        </div>
    </div>
    </div>

    <div>
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h3 class="modal-title" id="staticBackdropLabel">비밀번호 변경</h3>
                </div>
                <div class="modal-body">
                    <form>
                        <div id="pwd1">
                            <h4>기존 비밀번호</h4>
                            <input id="pwd" type="text" required/>
                        </div>
                        <div id="pwd2" style="display: none;">
                            <h4>새 비밀번호</h4>
                            <input id='newPwd' type='password' placeholder='내용을 입력해주세요'/>
                            <h4>비밀번호 확인</h4>
                            <input id='checkPwd' type='password' placeholder='내용을 입력해주세요'/>
                            <label id='check'></label>
                        </div>
                    </form>
                </div>
                <div id="modal-footer" class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                  <button type="button" id="pwdNext" class="btn btn-primary">next ></button>
                </div>
              </div>
            </div>
          </div>
    </div>

    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/info.js"></script>
</body>
</html>