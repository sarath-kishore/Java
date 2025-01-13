function setHoverOnShine(){
             // Code to detect screen height ends
         // Javascript to create button hover shine effect
            const buttons = document.querySelectorAll(".hover-shine");

            buttons.forEach(button => {
                ["mousemove"].forEach(evt => {
                    button.addEventListener(evt, e => {
                        let parentOffset = button.getBoundingClientRect(),
                            relX = e.pageX - parentOffset.left,
                            relY = e.pageY - parentOffset.top;
console.log(button);

                        const span = button.querySelector(".hover-span");
console.log(span);
                        span.style.top = relY + "px";
                        span.style.left = relX + "px";
                    });
                });
            });

}

window.addEventListener('load', ()=>{
//    loadAll();
    console.log('all loaded');

    // splashScreen.show();

    // (!loggedIn_user) && splashScreen.hide();
//
//    document.querySelectorAll('.password-showIcon').forEach((item)=>{
//        setPasswordChecker(item);
//    });

    setHoverOnShine();

    // console.log(loggedIn_user);


});