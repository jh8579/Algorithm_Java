# ✍️ 네이버 블로그 글 작성 도구

AI를 활용하여 주제만 입력하면 완벽한 네이버 블로그 글을 자동으로 작성해주는 도구입니다.

## 🚀 주요 기능

- **AI 기반 블로그 글 생성**: OpenAI GPT 모델을 사용하여 고품질 블로그 글 작성
- **다양한 글 스타일**: 친근한, 전문적인, 유머러스한, 감성적인 스타일 선택 가능
- **글 길이 조절**: 짧은(500자), 중간(1000자), 긴(1500자) 길이 선택
- **자동 저장**: 생성된 글을 텍스트 파일로 저장
- **클립보드 복사**: 한 번의 클릭으로 글 내용을 클립보드에 복사
- **아름다운 UI**: 모던하고 사용하기 쉬운 웹 인터페이스

## 📋 설치 방법

### 1. 저장소 클론
```bash
git clone <repository-url>
cd naver-blog-writer
```

### 2. Python 가상환경 생성 및 활성화
```bash
python -m venv venv
source venv/bin/activate  # Linux/Mac
# 또는
venv\Scripts\activate  # Windows
```

### 3. 필요한 패키지 설치
```bash
pip install -r requirements.txt
```

### 4. 환경 변수 설정
```bash
cp .env.example .env
```
`.env` 파일을 열어서 OpenAI API 키를 입력하세요:
```
OPENAI_API_KEY=your_actual_api_key_here
```

## 🔑 OpenAI API 키 발급

1. [OpenAI Platform](https://platform.openai.com/)에 가입
2. [API Keys](https://platform.openai.com/api-keys) 페이지에서 새 키 생성
3. 생성된 키를 `.env` 파일에 입력

## 🚀 실행 방법

```bash
python app.py
```

웹 브라우저에서 `http://localhost:5000`으로 접속하세요.

## 💻 사용 방법

1. **주제 입력**: 블로그에 작성하고 싶은 주제를 입력하세요
2. **스타일 선택**: 원하는 글 스타일을 선택하세요
3. **길이 선택**: 원하는 글 길이를 선택하세요
4. **생성 버튼 클릭**: AI가 블로그 글을 작성합니다
5. **결과 확인**: 생성된 글을 확인하고 필요에 따라 수정하세요
6. **저장 또는 복사**: 파일로 저장하거나 클립보드에 복사하세요

## 🎨 지원하는 글 스타일

- **친근하고 편안한**: 일상적이고 편안한 톤의 글
- **전문적이고 자세한**: 깊이 있고 전문적인 내용의 글
- **재미있고 유머러스한**: 유머와 재미가 있는 글
- **따뜻하고 감성적인**: 따뜻하고 공감되는 글

## 📁 프로젝트 구조

```
naver-blog-writer/
├── app.py              # Flask 메인 애플리케이션
├── requirements.txt    # Python 패키지 의존성
├── .env.example       # 환경 변수 설정 예시
├── README.md          # 프로젝트 설명서
└── templates/         # HTML 템플릿
    └── index.html     # 메인 웹 페이지
```

## 🔧 기술 스택

- **Backend**: Flask (Python)
- **Frontend**: HTML, CSS, JavaScript
- **AI**: OpenAI GPT-3.5-turbo
- **스타일링**: CSS3 (그라디언트, 애니메이션)
- **반응형 디자인**: 모바일과 데스크톱 모두 지원

## ⚠️ 주의사항

- OpenAI API 사용량에 따라 비용이 발생할 수 있습니다
- 생성된 글은 참고용이며, 필요에 따라 수정하여 사용하세요
- API 키는 절대 공개하지 마세요

## 🤝 기여하기

버그 리포트나 기능 제안은 언제든 환영합니다!

## 📄 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다.

## 📞 문의

프로젝트에 대한 문의사항이 있으시면 이슈를 등록해주세요.