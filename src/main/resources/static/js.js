// Salvamento do tema no cookie
function setCookie(name, value, days) {
    const date = new Date();
    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
    document.cookie = name + "=" + value + ";path=/;expires=" + date.toUTCString();
}

// Leitura do Cookie
function getCookie(name) {
    const cname = name + "=";
    const decodedCookie = decodeURIComponent(document.cookie);
    const cookies = decodedCookie.split(';');
    for (let c of cookies) {
        while (c.charAt(0) === ' ') c = c.substring(1);
        if (c.indexOf(cname) === 0) return c.substring(cname.length, c.length);
    }
    return "";
}

// Aplicando o tema
function applyTheme(theme) {
    if (theme === "dark") {
        document.body.classList.add("dark-theme");
    } else {
        document.body.classList.remove("dark-theme");
    }
}

// Alternando o tema
document.addEventListener("DOMContentLoaded", () => {
    const savedTheme = getCookie("theme") || "light";
    applyTheme(savedTheme);

    const button = document.getElementById("toggleTheme");
    if (button) {
        button.addEventListener("click", () => {
            const currentTheme = document.body.classList.contains("dark-theme") ? "dark" : "light";
            const newTheme = currentTheme === "dark" ? "light" : "dark";
            applyTheme(newTheme);
            setCookie("theme", newTheme, 7);
        });
    }
});
