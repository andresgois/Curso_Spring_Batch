select * from batch_job_instance;
SELECT job_execution_id, short_context, serialized_context FROM public.batch_job_execution_context;
SELECT job_instance_id, "version", job_name, job_key FROM public.batch_job_instance;
SELECT job_execution_id, parameter_name, parameter_type, parameter_value, identifying
FROM public.batch_job_execution_params;

-- LIMPA METADADOS
delete from BATCH_JOB_EXECUTION_CONTEXT;
delete from BATCH_JOB_EXECUTION_PARAMS;
delete from BATCH_JOB_EXECUTION_SEQ;

delete from BATCH_STEP_EXECUTION_CONTEXT;
delete from BATCH_STEP_EXECUTION_SEQ;
delete from BATCH_STEP_EXECUTION;

delete from BATCH_JOB_EXECUTION;
delete from BATCH_JOB_INSTANCE;
delete from BATCH_JOB_SEQ;