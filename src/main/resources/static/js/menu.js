document.addEventListener("DOMContentLoaded", function () {
  const readMoreBtn = document.getElementById("readMoreBtn");
  if (readMoreBtn) {
    readMoreBtn.addEventListener("click", () => {
      const extraText = document.getElementById("extraText");
      if (extraText) {
        extraText.classList.toggle("hidden");
      }
    });
  }

  const navLinks = document.querySelectorAll(".nav-link[data-target]");
  const pages = document.querySelectorAll(".page");

  navLinks.forEach(link => {
    link.addEventListener("click", e => {
      e.preventDefault();

      const targetId = link.getAttribute("data-target");

      if (document.getElementById(targetId)) {
        pages.forEach(p => p.classList.remove("active"));
        document.getElementById(targetId).classList.add("active");
      }

      if (targetId === "about") {
        document.querySelector(".sidebar-about")?.classList.toggle("active");
      } else {
        document
          .querySelectorAll(".sidebar-about")
          .forEach(box => box.classList.remove("active"));
      }

      if (targetId === "appointment") {
        document.querySelector(".sidebar-about")?.classList.toggle("active");
      } else {
        document
          .querySelectorAll(".sidebar-about")
          .forEach(box => box.classList.remove("active"));
      }

      if (targetId === "contact") {
        document.querySelector(".sidebar-about")?.classList.toggle("active");
      } else {
        document
          .querySelectorAll(".sidebar-about")
          .forEach(box => box.classList.remove("active"));
      }

      navLinks.forEach(n => n.classList.remove("active"));
      link.classList.add("active");
    });
  });
});

document.addEventListener("DOMContentLoaded", function () {
  const btn = document.getElementById("appointmentPageBtn");
  if (!btn) return;

  const hasAppointment = btn.dataset.hasAppointment === "true";

  if (!hasAppointment) {
    btn.classList.add("disabled");

    btn.addEventListener("click", function (e) {
      e.preventDefault();
      alert("Anda belum memiliki appointment. Silakan buat appointment terlebih dahulu.");
    });
  }
});
