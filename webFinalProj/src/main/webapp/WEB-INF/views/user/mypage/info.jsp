<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/info.css">
    <title>내정보</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<div class="info">
    <div>
    <div class="infoHeader">
        <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
        <label><h1>내정보</h1></label>
    </div>
    <div class="form-div">
    <form id="form-info" name="form" method="post" action="/checkMyinfo">
        <table>
            <c:choose>
				<c:when test="${account.getSocial_account_id() eq 'false'}">
					<tr>
		                <th>아이디</th>
		                <td colspan="3">${account.getAccount_id()} </td>
		                <input id="account_id" name="account_id" type="text" value="${account.account_id}" hidden/>
		            </tr>
				</c:when>
				<c:otherwise>
					<tr>
		                <th>아이디</th>
		                <td colspan="3">${account.getSocial_account_id()} </td>
		                <input id="social_account_id" name="social_account_id" type="text" value="${account.social_account_id}" hidden/>
		            </tr>
				</c:otherwise>
			</c:choose>
            <tr>
                <th>닉네임</th>
                <td colspan="2">
                    <label id="nick">${account.getNickname()}</label>
                    <input id="name" name="nickname" type="text" value="${account.getNickname()}" style="display: none;"/>
                </td>
                <td>
                    <button id="nick-Btn" type="button">변경하기</button>
                    <button class="back" type="button" style="display: none;">취소</button>
                </td>
            </tr>
            <c:choose>
				<c:when test="${account.getSocial_account_id() eq 'false'}">
					<tr>
		                <th>비밀번호</th>
		                <td colspan="3">
		                    <input id="password" name="password" type="text" value="${account.getPassword()}" hidden/>
		                    <button id="bootstrap-update-pwd" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">변경하기</button></td>
		            </tr>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
            <tr>
                <th>전화번호</th>
                <td colspan="2">
                    <label id="phone-label">${account.getPhone()}</label>
                    <input id="phone" name="phone" type="text" value="${account.getPhone()}" style="display: none;"/>
                </td>
                <td>
                    <button id="phone-Btn" type="button">수정하기</button>
                    <button class="back" type="button" style="display: none;">취소</button>
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td colspan="2">
                    <label id="email-text">${account.getEmail()}</label>
                    <input id="email" name="email" type="text" value="${account.getEmail()}" style="display: none;"/>
                </td>
                <td>
                    <button id="email-Btn" type="button">수정하기</button>
                    <button class="back" type="button" style="display: none;">취소</button>
                </td>
            </tr>
            <tr>
                <th rowspan="2">주소</th>
				<th>우편번호</th>
				<td colspan="2">
					<input type="hidden" id="confmKey" name="confmKey" value=""  >
					<input type="text" id="zipNo" name="zipNo" value="${account.getAddress_no()}" readonly style="width:100px" >
					<button type="button" onclick="goPopup();"> 주소검색</button>
				</td>
			</tr>
			<tr>
				<th>도로명주소</th>
				<td colspan="2">
                    <input type="text" id="roadFullAddr" name="address" style="width:100%" value="${account.getAddress()}" readonly>
                </td>
			</tr>
        </table>
    </form>
    </div>
    <hr>
    <div class="button">
        <a href="/drop">회원탈퇴</a>
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
                            <input id="pwd" type="password" required/>
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
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/mypage/info.js"></script>
<%@ include file="../common/footer.jsp"%>