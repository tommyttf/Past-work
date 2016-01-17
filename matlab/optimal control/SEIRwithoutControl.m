function [y,k]=SEIRwithoutControl(LAMBDA1,LAMBDA2,beta,d,alpha,epsilon,gamma,S0,E0,I0,R0,n)

test=-1;

delta=0.001;
t=linspace(0,5,n+1);          %final time = 5 years
h=5/n;
k=0;              

S=zeros(1,n+1);
S(1)=S0;
E=zeros(1,n+1);
E(1)=E0;
I=zeros(1,n+1);
I(1)=I0;
R=zeros(1,n+1);
R(1)=R0;
N=zeros(1,n+1);
N(1)=S0+E0+I0+R0;

lambda1=zeros(1,n+1);
lambda2=zeros(1,n+1);
lambda3=zeros(1,n+1);
lambda4=zeros(1,n+1);

M=zeros(1,n+1);
T=zeros(1,n+1);

while(test<0)
    
    oldS=S;
    oldE=E;
    oldI=I;
    oldR=R;
    
    oldlambda1=lambda1;
    oldlambda2=lambda2;
    oldlambda3=lambda3;
    oldlambda4=lambda4;
    
    k=k+1;
    
    for i =1:n
       S(i+1)=(S(i)+h*LAMBDA1)/(1+h*(d+beta*I(i)/N(i)));
       E(i+1)=(E(i)+(h*beta*S(i+1)*I(i)/N(i)))/(1+h*(alpha+d));
       I(i+1)=(I(i)+h*(LAMBDA2+alpha*E(i+1)))/(1+h*(epsilon+gamma+d));
       R(i+1)=(R(i)+h*(gamma)*I(i+1))/(i+h*d);
       N(i+1)=S(i+1)+E(i+1)+I(i+1)+R(i+1);
    end
    
    for i =0:n-1
       lambda1(n-i)=(lambda1(n-i+1)+h*lambda2(n-i+1)*beta*(I(n-i)/N(n-i)))/(1+h*(d+beta*(I(n-i)/N(n-i))));
       lambda2(n-i)=(lambda2(n-i+1)+h*(1+alpha*lambda3(n-i+1)))/(1+h*(alpha+d));
       lambda3(n-i)=(lambda3(n-i+1)+h*(1+(lambda1(n-i)-lambda2(n-i))*beta*(S(n-i)/N(n-i))))/(1+h*(epsilon+gamma+d));       
       lambda4(n-i)=lambda4(n-i+1)/(1+h*d);
    end
    
    temp3=delta*sum(abs(S))-sum(abs(oldS-S));
    temp4=delta*sum(abs(E))-sum(abs(oldE-E));
    temp5=delta*sum(abs(I))-sum(abs(oldI-I));
    temp6=delta*sum(abs(R))-sum(abs(oldR-R));
    
    temp7=delta*sum(abs(lambda1))-sum(abs(oldlambda1-lambda1));
    temp8=delta*sum(abs(lambda2))-sum(abs(oldlambda2-lambda2));
    temp9=delta*sum(abs(lambda3))-sum(abs(oldlambda3-lambda3));
    temp10=delta*sum(abs(lambda4))-sum(abs(oldlambda4-lambda4));
    
    test=min(temp3,min(temp4,min(temp5,min(temp6,min(temp7,min(temp8,min(temp9,temp10)))))));
end

y(1,:)=t;
y(2,:)=S;
y(3,:)=E;
y(4,:)=I;
y(5,:)=R;
y(6,:)=lambda1;
y(7,:)=lambda2;
y(8,:)=lambda3;
y(9,:)=lambda4;

subplot(2,1,1)
plot(y(1,:),y(3,:))
ylabel({'Exposed';'E(t)'})
xlabel('Time(years)')
hold all
subplot(2,1,2)
plot(y(1,:),y(4,:))
ylabel({'Infected';'I(t)'})
xlabel('Time(years)')
hold all