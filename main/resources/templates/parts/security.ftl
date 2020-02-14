<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        firstname = user.getFirstname()
        isAdmin = user.isAdmin()
    >
<#else>
    <#assign
        name = " "
    isAdmin = false
    >
</#if>