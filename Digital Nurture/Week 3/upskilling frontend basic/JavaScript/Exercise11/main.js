const form = document.getElementById("registrationForm");

function clearErrors() {
    document.querySelectorAll(".form-group").forEach(function (group) {
        group.classList.remove("error");
    });
}

function setError(groupId) {
    document.getElementById(groupId).classList.add("error");
}

function validateEmail(email) {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

form.addEventListener("submit", function (e) {
    e.preventDefault();
    clearErrors();

    const formData = new FormData(form);
    const name = formData.get("fullName").trim();
    const email = formData.get("email").trim();
    const phone = formData.get("phone").trim();
    const eventSelect = formData.get("eventSelect");
    const message = formData.get("message").trim();

    let isValid = true;

    if (name.length < 2) {
        setError("nameGroup");
        isValid = false;
    }

    if (!validateEmail(email)) {
        setError("emailGroup");
        isValid = false;
    }

    if (phone && !/^[\d\s\-\(\)\+]{7,}$/.test(phone)) {
        setError("phoneGroup");
        isValid = false;
    }

    if (!eventSelect) {
        setError("eventGroup");
        isValid = false;
    }

    if (isValid) {
        const output = document.getElementById("formOutput");
        output.innerHTML = `
            <h3 style="color:#198754;margin-bottom:0.5rem;">Registration Successful!</h3>
            <p><strong>Name:</strong> ${name}</p>
            <p><strong>Email:</strong> ${email}</p>
            <p><strong>Phone:</strong> ${phone || "Not provided"}</p>
            <p><strong>Event:</strong> ${eventSelect}</p>
            <p><strong>Message:</strong> ${message || "None"}</p>
        `;
        form.reset();
    }
});

// Real-time validation feedback
document.getElementById("fullName").addEventListener("blur", function () {
    const group = document.getElementById("nameGroup");
    if (this.value.trim().length < 2 && this.value.length > 0) {
        group.classList.add("error");
    } else {
        group.classList.remove("error");
    }
});

document.getElementById("email").addEventListener("blur", function () {
    const group = document.getElementById("emailGroup");
    if (this.value.length > 0 && !validateEmail(this.value)) {
        group.classList.add("error");
    } else {
        group.classList.remove("error");
    }
});
