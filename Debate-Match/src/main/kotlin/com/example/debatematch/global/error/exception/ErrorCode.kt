package com.example.debatematch.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    FEIGN_FORBIDDEN(403, "Feign Forbidden"),
    DEBATE_NOT_IN_PROGRESS(400, "Debate not in-progress"),
    DUPLICA_EXCEPTION(409, "Duplica exception"),
    EXISTS_SELF_STUDY_TEACHER(409, "Exists Self Study Teacher"),
    ALREADY_APPLYING_EARLY_RETURN(409, "Already applying For Early Return Application"),
    ALREADY_APPLYING_PICNIC(409, "Already applying For Picnic Application"),
    ALREADY_APPLYING_MOVEMENT(409, "Already applying for movement"),
    DUPLICATE_USER(409, "Duplicate User"),
    PLAYER_ALREADY_OWNED(401, "Player already owned"),

    FEIGN_UNAUTHORIZED(401, "Feign UnAuthorized"),
    PASSWORD_MISS_MATCH(401, "Password Miss Match"),
    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),
    SECRET_KEY_MISS_MATCH(401, "Secret Key Miss Match"),
    INVALID_DEBATE_REACTION(401, "InvalidDebateReactionException"),

    EXPIRED_EMAIL_CODE(401, "Expired Email Code"),
    EMAIL_CODE_MISSMATCH(401, "Email Mismatch"),

    USER_NOT_FOUND(404, "User Not Found"),
    ADMIN_NOT_FOUND(404, "Admin Not Found"),
    SELF_STUDY_NOT_FOUND(404, "Self Study Not Found"),
    EARLY_RETURN_NOT_FOUND(404, "Early Return Application Not Found"),
    APPLICATION_NOT_FOUND(404, "Application Not Found"),
    STATUS_NOT_FOUND(404, "Status Not Found"),
    CLASSROOM_NOT_FOUND(404, "Classroom Not Found"),
    WEEKEND_MEAL_NOT_FOUND(404, "WeekendMeal Not Found"),
    CLUB_NOT_FOUND(404, "Club Not Found"),
    NOTICE_NOT_FOUND(404, "Notice Not Found"),
    SCHEDULE_NOT_FOUND(404, "Schedule Not Found"),
    FLOOR_NOT_FOUND(404, "Floor Not Found"),
    TEACHER_NOT_FOUND(404, "Teacher Not Found"),
    TIMETABLE_NOT_FOUND(404, "Timetable Not Found"),
    SseEmitterAlreadyCompletedException(400,""),

    NOT_ADMIN(403, "Not an Admin"),
    NOT_STUDENT(403, "Not an Student"),
    CANCEL_INPUT_ERROR(401, "Cancel Input Error"),

    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),
    FILE_IS_EMPTY(400, "File does not exist"),
    BAD_FILE_EXTENSION(400, "File Extension is invalid"),
    MAX_UPLOAD_FILE(400, "Max Upload File Size"),
    INVALID_PERIOD(400, "Invalid period"),
    INVALID_TIME(400, "Invalid Time"),
    INVALID_SUBJECT(400, "Invalid Subject"),
    UNABLE_APPLY(400, "Unable To Apply"),

    NOT_EXTENSION_XSL(415, "Not Extension XSL"),

    // Internal Server Error
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    FEIGN_SERVER_ERROR(500, "Feign Server Error"),
    GOOGLE_OAUTH_SERVER_ERROR(500, "Google Oauth Server Error"),
    FCM_SERVER_ERROR(500, "Fem Server Error"),
    FCM_INITIALIZATION_ERROR(500, "FCM Initialization Error"),
    DUPLICATED_USER(409, "Duplicate User Error"),
    ALREADY_STARTED_DEBATE(409, "Already started")
}
