<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.7.0.js"></script>
</head>
<body>
	<h1>메인</h1>
	<table id="membersTable" border=1px>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Organization</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	<script>	
  $(document).ready(function() {
    // REST API 호출
    $.ajax({
      url: "http://localhost:8081/api/v1/member/members",
      type: "GET",
      dataType: "json",
      success: function(data) {
        // 결과를 테이블에 표시
        for (var i = 0; i < data.length; i++) {
          var member = data[i];
          var tableRow = "<tr>"
              + "<td>" + member.id + "</td>"
              + "<td>" + member.name + "</td>"
              + "<td>" + member.email + "</td>"
              + "<td>" + member.organization + "</td>"
              + "</tr>";

          $("#membersTable tbody").append(tableRow);
        }
      },
      error: function(err) {
        console.error(err);
        alert("An error occurred while fetching data.");
      }
    });
  });
</script>

</body>
</html>