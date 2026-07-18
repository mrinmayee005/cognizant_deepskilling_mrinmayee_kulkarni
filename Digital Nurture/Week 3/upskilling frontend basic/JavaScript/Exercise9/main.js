function showLoading(containerId) {
    const container = document.getElementById(containerId);
    container.innerHTML = '<div class="loading"><span class="spinner"></span> Loading events...</div>';
    return container;
}

function simulateFetch(data, shouldFail) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            if (shouldFail) {
                reject(new Error("Network error: Unable to fetch events."));
            } else {
                resolve(data);
            }
        }, 1500);
    });
}

const mockEvents = [
    { id: 1, title: "Summer Music Festival", category: "music", date: "2026-08-15" },
    { id: 2, title: "Community Garden Day", category: "outdoor", date: "2026-07-20" },
    { id: 3, title: "Tech Meetup", category: "tech", date: "2026-09-10" },
    { id: 4, title: "Art in the Park", category: "art", date: "2026-08-25" }
];

function renderPosts(container, events) {
    container.innerHTML = events.map(function (event) {
        return `<div class="post-card"><strong>${event.title}</strong><br>Category: ${event.category} | Date: ${event.date}</div>`;
    }).join("");
}

// Promise .then() approach
function loadEventsPromise() {
    const container = showLoading("promiseResult");

    simulateFetch(mockEvents, false)
        .then(function (events) {
            renderPosts(container, events);
        })
        .catch(function (error) {
            container.innerHTML = `<div class="error">${error.message}</div>`;
        });
}

// Async/Await approach
async function loadEventsAsync() {
    const container = showLoading("asyncResult");

    try {
        const events = await simulateFetch(mockEvents, false);
        renderPosts(container, events);
    } catch (error) {
        container.innerHTML = `<div class="error">${error.message}</div>`;
    }
}

// Error handling demo
async function loadWithError() {
    const container = showLoading("errorResult");

    try {
        const events = await simulateFetch(mockEvents, true);
        renderPosts(container, events);
    } catch (error) {
        container.innerHTML = `<div class="error">Failed to load: ${error.message}</div><p style="margin-top:0.5rem;color:#666;">Retrying in 2 seconds...</p>`;

        setTimeout(async function () {
            try {
                const retryEvents = await simulateFetch(mockEvents, false);
                container.innerHTML = `<div class="success">Retry successful!</div>`;
                renderPosts(container, retryEvents);
            } catch (retryError) {
                container.innerHTML = `<div class="error">Retry also failed: ${retryError.message}</div>`;
            }
        }, 2000);
    }
}

// Fetch from JSONPlaceholder as real-world example
async function loadFromAPI() {
    try {
        const response = await fetch("https://jsonplaceholder.typicode.com/posts?_limit=5");
        if (!response.ok) throw new Error("API request failed");
        const posts = await response.json();
        console.log("Fetched posts from API:", posts);
        return posts;
    } catch (error) {
        console.error("API fetch error:", error);
        return [];
    }
}

loadFromAPI();
