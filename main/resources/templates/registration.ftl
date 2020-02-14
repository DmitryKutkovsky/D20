<#import "parts/common1.ftl" as c1>
<#import "parts/login.ftl" as l>

<@c1.page>
${message?ifExists}
<@l.login "/registration" true/>
</@c1.page>