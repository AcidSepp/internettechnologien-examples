const playground = async (scriptName) => {

    const oldLog = console.log;
    console.log = function(message) {
        oldLog.apply(console, arguments); // Keep logging to the console
        document.getElementById("logOutput").innerText += message + "\n"; // Append message to div
    };

    const scriptPlace = document.getElementById("scriptPlace");

    try {
        const response = await fetch(scriptName);
        if (!response.ok) {
            throw new Error("Failed to load script");
        }

        let scriptContent = await response.text();

        scriptContent = (typeof js_beautify !== "undefined") ? js_beautify(scriptContent) : scriptContent;

        scriptPlace.innerText = scriptContent;

        document.getElementById("runScript").addEventListener("click", function () {
            eval(scriptContent);
        });
    } catch (error) {
        scriptPlace.innerText = "Error loading script: " + error.message;
    }
}
