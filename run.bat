@echo off
chcp 65001 >nul
echo 🚀 네이버 블로그 글 작성 도구를 시작합니다...

REM Python 가상환경이 있는지 확인
if not exist "venv" (
    echo 📦 Python 가상환경을 생성합니다...
    python -m venv venv
)

REM 가상환경 활성화
echo 🔧 가상환경을 활성화합니다...
call venv\Scripts\activate.bat

REM 필요한 패키지 설치
echo 📚 필요한 패키지를 설치합니다...
pip install -r requirements.txt

REM .env 파일이 있는지 확인
if not exist ".env" (
    echo ⚠️  .env 파일이 없습니다!
    echo 📝 .env.example을 복사하여 .env 파일을 만들고 OpenAI API 키를 입력해주세요.
    copy .env.example .env
    echo 🔑 .env 파일에 OpenAI API 키를 입력한 후 다시 실행해주세요.
    pause
    exit /b 1
)

REM 애플리케이션 실행
echo 🌐 웹 애플리케이션을 시작합니다...
echo 📱 브라우저에서 http://localhost:5000 으로 접속하세요.
echo ⏹️  종료하려면 Ctrl+C를 누르세요.

python app.py
pause