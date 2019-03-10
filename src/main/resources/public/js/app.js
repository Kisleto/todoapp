
const view = new View();

new Controller(view);

window.addEventListener('load', function () {
    var idToken;
    var accessToken;
    var expiresAt;

    var webAuth = new auth0.WebAuth({
        domain: 'localhost:8080/',
        clientID: '07yN-b2y70-eXA2BeUUAzWHL8Vicd-M8',
        responseType: 'token id_token',
        scope: 'openid',
        redirectUri: window.location.href
    });

    var loginBtn = document.getElementById('btn-login');

    loginBtn.addEventListener('click', function (e) {
        e.preventDefault();
        webAuth.authorize();
    })
});