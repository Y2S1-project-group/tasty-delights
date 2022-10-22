function showHidePassword(){
    const val = document.getElementById('password');
    if (val.type === 'password') {
        val.type = 'text';
    }else{
        val.type = 'password';
    }
}