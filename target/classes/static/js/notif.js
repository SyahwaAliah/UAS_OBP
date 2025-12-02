document.addEventListener("DOMContentLoaded", function() {
    const notif = document.getElementById("notifPanel");
    
    if (notif) {
        notif.classList.add("show");

        setTimeout(() => {
            notif.classList.remove("show");
        }, 5000);
    }
});
