<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#profile {
 max-width: 150px;
}

th:nth-child(1) {
 width: 80px;
}

th:nth-child(2) {
 width: 50%;
}

th:nth-child(4) {
 width: 75px;
}

input[type='text'] {
 width: 100%;
}

#map {
 display: none;
 width: 100%;
 height: 300px;
}

#img-profile {
 width: 150px;
}
</style>
</head>
<body>
    <%@ include file="/WEB-INF/views/fragments/header.jsp"%>
    <div class="container">
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-5">
                    <div class="card mb-4">
                        <div class="card-header">
                            <h4>회원 정보</h4>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <p>
                                        <strong>회원번호:</strong> ${member.mno}
                                    </p>
                                    <p>
                                        <strong>이름:</strong> ${member.name}
                                    </p>
                                    <p>
                                        <strong>이메일:</strong> ${member.email}
                                    </p>
                                    <p>
                                        <strong>권한:</strong> ${member.role}
                                    </p>
                                </div>

                                <!-- 이미지 표시 -->
                                <div class="mt-3 col-md-6 text-center">
                                    <img alt="" src="${member.profileImg }" id="img-profile">
                                </div>
                            </div>
                            <c:if
                                test="${loginUser.email.equals(member.email) || loginUser.role.equalsIgnoreCase('ADMIN')}">
                                <div class="d-flex mt-5 justify-content-center">
                                    <form method="post" action="${root}/auth/member-delete" id="form-delete">
                                        <input type="hidden" name="mno" value="${member.mno}">
                                        <input type="hidden" name="email" value="${member.email }">
                                        <button type="button" class="btn btn-primary mx-3" onclick="updateMember()">수정</button>
                                        <button type="submit" class="btn btn-danger  mx-3" onclick="deleteMember()">삭제</button>
                                        <button type="button" class="btn btn-danger  mx-3"
                                            onclick="updateMemberProfile()">프로필변경</button>
                                    </form>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>

                <div class="col-md-7">
                    <div class="card">

                        <div class="card-header">
                            <h4>주소 정보</h4>
                        </div>
                        <div class="card-body">
                            <table class="table table-bordered" id="table-user-address">
                                <thead>
                                    <tr>
                                        <th>주소 제목</th>
                                        <th>주소</th>
                                        <th>상세 주소</th>
                                        <th>편집</th>
                                    </tr>
                                </thead>
                                <tbody id="address-body">

                                </tbody>
                            </table>
                            <div id="map"></div>
                            <hr>
                            <form id="formAddressAdd">
                                <fieldset class="row g-3">
                                    <!-- address 등록용 -->
                                    <input type="hidden" name="mno" value="${member.mno}">
                                    <!-- member detail 조회용 -->
                                    <input type="hidden" name="email" value="${member.email}">
                                    <input type="hidden" name="x" id="x">
                                    <input type="hidden" name="y" id="y">
                                    <div class="col-md-2">
                                        <label for="addr_title" class="form-label">제목</label>
                                        <input type="text" class="form-control" id="title" name="title" required
                                            value="테스트">
                                    </div>
                                    <div class="col-md-5">
                                        <label for="addr_main" class="form-label">주소</label>
                                        <input type="text" class="form-control" id="address" name="address" required
                                            value="서울특별시 강남구 역삼동">
                                    </div>
                                    <div class="col-md-5">
                                        <label for="addr_detail" class="form-label">상세주소</label>
                                        <input type="text" class="form-control" id="detailAddress" name="detailAddress"
                                            required value="멀티캠퍼스">
                                    </div>
                                    <div class="col-12 text-end">
                                        <button type="button" class="btn btn-primary" data-mno="${member.mno }"
                                            id="btn-address-add">추가</button>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <c:if test="${!empty error }">
            <div class="alert alert-danger" role="alert">${error }</div>
        </c:if>


        <dialog id="profileDialog"> <input type="file" name="profile" id="profile">
        <button class="btn btn-primary" id="btn-profile-regist">등록</button>
        <button class="btn btn-primary" id="btn-dialog-close">닫기</button>
        </dialog>
    </div>
    <%@ include file="/WEB-INF/views/fragments/footer.jsp"%>
</body>
<script>
const key_vworld = `${key_vworld}`;
const key_sgis_service_id = `${key_sgis_service_id}`;
const key_sgis_security = `${key_sgis_security}`; // 보안 key
const key_data = `${key_data}`;
</script>
<script src="https://sgisapi.kostat.go.kr/OpenAPI3/auth/javascriptAuth?consumer_key=${key_sgis_service_id }"></script>
<script src="${root }/js/common.js"></script>


<script>
const map = sop.map("map");
map.mks = []; // marker 정보 관리
const addrInfos = []; // 지도 정보를 저장할 배열
<c:forEach var="addr" items="${member.addresses}">
// 테이블에서 사용되는 정보:  addr.ano, addr.address, addr.detailAddress, addr.title
// map에서 사용되는 정보: addr.title, addr.x, addr.y
addrInfos.push({ano:"${addr.ano}",                     
                address:"${addr.address}",
                detailAddress:"${addr.detailAddress}",
                title:"${addr.title}",               
                x:"${addr.x}", y:"${addr.y}"}
);
</c:forEach>

const showAddress = (addrInfos)=>{
    const target = document.querySelector("#address-body");
    target.innerHTML = "";
    if(addrInfos.length>0){
        document.querySelector("#map").style.display="block";
        addrInfos.forEach(item =>{
            target.innerHTML+=`
                <tr>
                  <td>\${item.title}</td>
                  <td>\${item.address}</td>
                  <td>\${item.detailAddress}</td>
                  <td><button class="btn btn-danger" data-ano="\${item.ano}" onclick="deleteAddress(event)">삭제</button></td>
                </tr>
            `;
        })
        updateMap(map, addrInfos);
    }else{
        document.querySelector("#map").style.display="none";
    }
}
showAddress(addrInfos);
</script>


<script>
document.querySelector("#btn-address-add").addEventListener("click", async (e)=>{
    try{
        // 주소를 이용한 좌표 조회 및 form update
        const address = document.querySelector('#address').value+" "+document.querySelector("#detailAddress").value;
        const coord = await getCoords(address);
        if(coord.x){ // 좌표가 전송된 경우만 submit 처리
            document.querySelector("#x").value = coord.x;
            document.querySelector("#y").value = coord.y;
        }else{
            alert(coord.errMsg);
            return;
        }
        // form 정보를 이용해 parameter 생성
        const formData = new FormData(document.querySelector("#formAddressAdd"));
        const searchParam = new URLSearchParams(formData).toString();
        console.log(searchParam);
        // 등록 요청 -> 전체 주소 획득
        const result = await postFetch("${root }/auth/address-insert", searchParam);
        if(result.error){
            alert(result.error);
        }else{
            // 화면 update
            showAddress(result);
        }
        console.log(formData);
    }catch(e){
        console.log(e)
    }
});

const deleteAddress = async (e)=>{
 if(confirm("삭제하시겠습니까?")){
     const params ={
           ano:e.target.dataset.ano,
           email:"${member.email}"
     }
     
     const result = await postFetch("${root}/auth/address-delete", new URLSearchParams(params).toString());
     if(result.error){
         alert(result.error);
     }else{
         showAddress(result);
     }
 }
}

const updateMember = ()=>{
    location.href="${root}/auth/member-modify-form?email=${member.email}"
};

const deleteMember = ()=>{
    const result = confirm("삭제하시겠습니까?");
    if(result){
        document.querySelector("#form-delete").submit();
    }
   };
</script>

<!-- TODO: 05-5. ajax를 통한 file upload를 확인하세요. -->
<script>
const updateMemberProfile = ()=>{
    const dialog = document.querySelector("#profileDialog");
    if(!dialog.open){
        dialog.showModal();
    }
};
    
    document.querySelector("#btn-dialog-close").addEventListener("click", ()=>{
        const dialog = document.querySelector("#profileDialog");
            dialog.close();
    });
    
    document.querySelector("#btn-profile-regist").addEventListener("click", async()=>{
        const formData = new FormData();
        const file = document.querySelector("#profile").files[0];
        formData.append("file", file);
        formData.append("email", "${member.email}")
        try{
            const response = await fetch("${root}/auth/profileajax", {
               method:"post",
              body: formData
             })
            const json = await response.json();
            if(json.img){
                document.querySelector("#img-profile").src=json.img;
            }else{
               alert(json.error);    
            }
            
            document.querySelector("#btn-dialog-close").click();
        }catch(e){
            console.log("profile upload fail", e)
        }
    })
</script>
</html>
