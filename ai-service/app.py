from flask import Flask, request, jsonify
import requests
import os
from dotenv import load_dotenv

load_dotenv()

app = Flask(__name__)
GROQ_API_KEY = os.getenv("GROQ_API_KEY")
GROQ_URL = "https://api.groq.com/openai/v1/chat/completions"

print("API Key:", GROQ_API_KEY)

@app.route("/ask", methods=["POST"])
def ask():
    user_input = request.json.get("query")
    payload = {
        "model": "llama3-70b-8192",
        "messages": [
            {"role": "system", "content": "You are a helpful assistant for table reservations."},
            {"role": "user", "content": user_input}
        ]
    }
    headers = {
        "Authorization": f"Bearer {GROQ_API_KEY}",
        "Content-Type": "application/json"
    }
    try:
        response = requests.post(GROQ_URL, headers=headers, json=payload)
        print("Groq response:", response.text)
        data = response.json()
        return jsonify({"response": data["choices"][0]["message"]["content"]})
    except Exception as e:
        return jsonify({"error": str(e)}), 500

if __name__ == "__main__":
    app.run(port=5001)
