package mariposas.constant;

public class AppConstant {
    public static final String USERS_NOT_FOUND = "Mentora ou mentorada não encontradas";
    public static final String USER_NOT_FOUND = "Usuária não encontrada";
    public static final String LOGIN_FAIL = "Acesso não concedido";
    public static final String GET_IMAGE_ERROR = "Erro ao buscar imagem no bucket";
    public static final String SPONSORSHIP_SUCCESS = "Apadrinhamento realizado com sucesso!";
    public static final String SPONSORSHIP_ERROR = "Erro ao realizar o apadrinhamento";
    public static final String SPONSORSHIP_CANCEL_SUCCESS = "Apadrinhamento cancelado com sucesso";
    public static final String SPONSORSHIP_CANCEL_ERROR = "Erro ao cancelar apadrinhamento";
    public static final String GET_MENTOR_ERROR = "Erro ao buscar perfil de mentora";

    public static final String BUCKET_PATH = "profile-images/";

    public static final String QUERY_GET_MENTEES = "SELECT u.name, u.email, u.phone, u.profile, " +
            "u.age, ml.\"level\" AS menteeLevel, u.image " +
            "FROM public.users u JOIN public.mentees m ON u.id = m.user_id " +
            "JOIN public.mentee_level ml on m.mentee_level_id = ml.id " +
            "WHERE m.is_sponsored  = false";
    public static final String QUERY_COUNT_MENTEES = "SELECT COUNT(*) FROM public.mentees";

    public static final String QUERY_GET_MENTOR = "SELECT u.name, u.email, u.phone, u.profile, u.age, u.image " +
            "from public.users u " +
            "JOIN public.mentors mt on u.id = mt.user_id " +
            "JOIN public.mentorship mp on mt.id = mp.mentor_id " +
            "JOIN public.mentees m on m.id = mp.mentee_id WHERE m.id = :id";
}