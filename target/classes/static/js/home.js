document.addEventListener("DOMContentLoaded", () => {
    const chars = document.querySelectorAll(".char");

    chars.forEach((c) => {
        const delay = Math.random() * 2;
        c.style.animationDelay = delay + "s";
    });
});
