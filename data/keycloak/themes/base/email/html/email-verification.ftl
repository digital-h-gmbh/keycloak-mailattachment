<html>
<body>
${kcSanitize(msg("emailVerificationBodyHtml",link, linkExpiration, realmName, linkExpirationFormatter(linkExpiration)))?no_esc}
<!-- !attach:files/test.pdf -->
</body>
</html>