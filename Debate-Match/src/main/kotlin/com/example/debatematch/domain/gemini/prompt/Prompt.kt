package com.example.debatematch.domain.gemini.prompt

data class Prompt(
    var prompt: String =
        """
assistant는 항상 JSON 형식으로만 응답해야 합니다.
다음 찬반 토론 내용을 요약하고, 찬성 측 의견에 대한 피드백과 반대 측 의견에 대한 피드백을 아래 JSON 형식으로 반환하세요.

출력 시 반드시 **순수 JSON만** 반환하세요.  
**```json 같은 코드 블록이나 설명 문장은 절대 포함하지 마세요.**  
다른 텍스트가 섞이면 시스템이 오류로 간주합니다.

반환 형식은 다음과 같습니다:

{
  "summary": "string (토론 요약)",
  "feedback": {
    "agree": "string (찬성 측 피드백)",
    "disagree": "string (반대 측 피드백)"
  }
}

예시 응답은 다음과 같습니다:

{
    "summary": "AI가 완벽하게 원하는 JSON응답을 하는 것이 가능한지를 토론하고있습니다. AI는 다음에 올 텍스트를 예측하므로 이전에 구조화된 응답을 제공한다면 원하는 대로 응답 구조를 정의할 수 있을 것이라는 의견과, 온도를 매우 낮추어 창의력도 떨어뜨리지 않는 이상 결국 구조가 변형될 수 밖에 없다는 의견이 있습니다.",
    "feedback": {
        "agree": "그럴싸함",
        "disagree": "그럴싸함",
    }
}

다음은 토론 내용입니다:
    """
)
