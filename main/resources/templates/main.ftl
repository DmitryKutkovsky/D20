<#import "parts/common1.ftl" as c>


<@c.page>

<div class="py-2 text-center mt-2"><b>СПИСОК ДОКЛАДЧИКОВ</b></div>
<#list users as user>
<#if user.status="Speaker">
<div class="container mt-2">
<div class="row mt-2">
    <div class="col-10" >
        <p class="text-sm-center">${user.firstname} ${user.lastname}--<b>«${user.section}»</b>--${user.date}</p>

            </div>
        </div>
 </div>


</#if>
</#list>
</@c.page>
