<#import "parts/common.ftl" as c>

<@c.page>
<div class="py-2 text-center mt-2"><b>Список зарегистрированных участников</b></div>


<#list users as user>
<div class="row mt-2">
    <div class="col-12" >
        <p class="text-sm-center">${user.firstname}   ${user.lastname}  <b>«${user.section}»</b>   ${user.date}
            ${user.phonenumber}  <b>${user.username}</b>   ${user.status}  <a href="/user/${user.id}">edit</a></p>
    </div>
</div>
</#list>
</@c.page>