from flask import Flask, render_template, request, jsonify
import openai
import os
from dotenv import load_dotenv
import json
from datetime import datetime

# 환경 변수 로드
load_dotenv()

app = Flask(__name__)

# OpenAI API 키 설정
openai.api_key = os.getenv('OPENAI_API_KEY')

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/generate_blog', methods=['POST'])
def generate_blog():
    try:
        data = request.get_json()
        topic = data.get('topic', '')
        style = data.get('style', '친근한')
        length = data.get('length', '중간')
        
        if not topic:
            return jsonify({'error': '주제를 입력해주세요.'}), 400
        
        # 블로그 글 생성 프롬프트
        prompt = f"""
다음 주제로 네이버 블로그 글을 작성해주세요:

주제: {topic}
글 스타일: {style}
글 길이: {length}

다음 형식으로 작성해주세요:
1. 제목 (매력적이고 검색에 최적화된 제목)
2. 소개 (주제에 대한 간단한 소개)
3. 본문 (3-4개의 섹션으로 구성, 각 섹션은 2-3문단)
4. 마무리 (요약 및 다음 글에 대한 기대감)
5. 태그 (관련 키워드 5-8개)

네이버 블로그에 적합한 친근하고 읽기 쉬운 톤으로 작성해주세요.
"""

        # OpenAI API 호출
        response = openai.ChatCompletion.create(
            model="gpt-3.5-turbo",
            messages=[
                {"role": "system", "content": "당신은 네이버 블로그 전문 작가입니다. 친근하고 유용한 블로그 글을 작성합니다."},
                {"role": "user", "content": prompt}
            ],
            max_tokens=1500,
            temperature=0.7
        )
        
        blog_content = response.choices[0].message.content
        
        return jsonify({
            'success': True,
            'content': blog_content,
            'topic': topic
        })
        
    except Exception as e:
        return jsonify({'error': f'오류가 발생했습니다: {str(e)}'}), 500

@app.route('/save_blog', methods=['POST'])
def save_blog():
    try:
        data = request.get_json()
        topic = data.get('topic', '')
        content = data.get('content', '')
        
        if not topic or not content:
            return jsonify({'error': '주제와 내용을 모두 입력해주세요.'}), 400
        
        # 블로그 글을 파일로 저장
        filename = f"blog_{topic.replace(' ', '_')[:20]}.txt"
        with open(filename, 'w', encoding='utf-8') as f:
            f.write(f"제목: {topic}\n")
            f.write(f"생성일: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n")
            f.write("="*50 + "\n")
            f.write(content)
        
        return jsonify({
            'success': True,
            'message': f'블로그 글이 {filename}에 저장되었습니다.',
            'filename': filename
        })
        
    except Exception as e:
        return jsonify({'error': f'저장 중 오류가 발생했습니다: {str(e)}'}), 500

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)