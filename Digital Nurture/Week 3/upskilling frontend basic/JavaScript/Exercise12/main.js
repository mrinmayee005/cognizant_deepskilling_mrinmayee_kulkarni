// GET Request using fetch()
async function fetchEvents() {
    const status = document.getElementById("fetchStatus");
    const container = document.getElementById("postsContainer");

    status.innerHTML = '<span class="spinner"></span> Fetching events...';
    status.className = "status pending";
    container.innerHTML = "";

    try {
        const response = await fetch("https://jsonplaceholder.typicode.com/posts?_limit=8");

        if (!response.ok) {
            throw new Error(`HTTP ${response.status}: ${response.statusText}`);
        }

        const data = await response.json();

        status.innerHTML = `Successfully fetched ${data.length} events`;
        status.className = "status success";

        container.innerHTML = data.map(function (post) {
            return `<div class="post-item"><strong>${post.title}</strong><br>${post.body.substring(0, 80)}...</div>`;
        }).join("");
    } catch (error) {
        status.innerHTML = `Error: ${error.message}`;
        status.className = "status error";
    }
}

// POST Request using fetch()
async function submitEvent() {
    const title = document.getElementById("postTitle").value.trim();
    const body = document.getElementById("postBody").value.trim();
    const status = document.getElementById("postStatus");

    if (!title || !body) {
        status.innerHTML = "Please fill in both title and description.";
        status.className = "status error";
        return;
    }

    status.innerHTML = '<span class="spinner"></span> Submitting event...';
    status.className = "status pending";

    try {
        const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({
                title: title,
                body: body,
                userId: 1
            })
        });

        if (!response.ok) {
            throw new Error(`HTTP ${response.status}`);
        }

        const result = await response.json();

        status.innerHTML = `Event submitted successfully! (ID: ${result.id})`;
        status.className = "status success";

        document.getElementById("postTitle").value = "";
        document.getElementById("postBody").value = "";
    } catch (error) {
        status.innerHTML = `Submission failed: ${error.message}`;
        status.className = "status error";
    }
}

// setTimeout simulation
function simulateTimeout() {
    const status = document.getElementById("timeoutStatus");
    status.innerHTML = '<span class="spinner"></span> Waiting for response (3 second delay)...';
    status.className = "status pending";

    const timeoutPromise = new Promise(function (resolve, reject) {
        const timeoutId = setTimeout(function () {
            resolve({ message: "Data loaded successfully after delay!" });
        }, 3000);

        // Allow cancellation (not triggered in normal flow)
        window._timeoutCancel = function () {
            clearTimeout(timeoutId);
            reject(new Error("Request cancelled."));
        };
    });

    timeoutPromise
        .then(function (result) {
            status.innerHTML = result.message;
            status.className = "status success";
        })
        .catch(function (error) {
            status.innerHTML = `Cancelled: ${error.message}`;
            status.className = "status error";
        });
}
