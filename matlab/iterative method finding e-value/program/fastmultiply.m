%matlab R2013a
function c=fastmultiply(a,b)

[M,N]=size(a);

a_N=a(N);
b_N=b(N);

a=a/(a_N);
b=b/(b_N);

for i=N+1:2*N-1
    a(i)=0;
    b(i)=0;
end

y_p=fft(a);
y_q=fft(b);

y_r=y_p.*y_q;

y_r=y_r-1;

c=ifft(y_r);

c=a_N*b_N*c;

c(1)=a(1)*b(1)*a_N*b_N;
%I don't know if there is any rounding off while doing the fft and
%ifft,which make c(1) don't get the correct value in my computer